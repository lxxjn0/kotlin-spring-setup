# kotlin-sandbox

## Kotlin code style

### [kotlin coding convention](https://kotlinlang.org/docs/coding-conventions.html)

Apply the style guide

1. Go to Settings/Preferences | Editor | Code Style | Kotlin.

2. Click Set from....

3. Select Kotlin style guide.

### [ktlint](https://github.com/pinterest/ktlint)

rules : https://ktlint.github.io/#rules

gradle plugin : [jlleitschuh/ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle)

`.editorconfig` 파일에 ktlint 관련 설정 작성

```kotlin
plugins {
    // ...

    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
    id("org.jlleitschuh.gradle.ktlint-idea") version "10.3.0"
}
```

`Gradle > Tasks` 에서 ktlint 실행 또는 아래 명령어를 통해 실행 가능

```bash
# ktlint check task (ktlint 체크, convention에 어긋난 부분 확인)
./gradlew ktlintCheck --continue
./gradlew :moduleName:ktlintCheck --continue

# ktlint format task (ktlint 포맷팅, convention에 어긋난 부분 수정)
./gradlew ktlintFormat
./gradlew :moduleName:ktlintFormat
```

indentation으로 4 space 사용 (woowa-initializr는 2 space를 사용하지만 [kotlin convention 문서](https://kotlinlang.org/docs/coding-conventions.html#indentation)를 참고하여서 4 space 사용)

## Project setting

### buildSrc 설정

> buildSrc는 빌드 로직을 포함할 수 있는 gradle 프로젝트 루트 directory

전체 프로젝트 경로에 `buildSrc` 이름의 디렉토리를 생성, `build.gradle.kts` 파일 생성 후 아래의 코드 작성 (`kotlin-dsl` 플러그인을 사용하기 위한 설정)

```kotlin
plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

```

### `build.gradle.kts` 설정

`gradle.properties` 값을 가져오고 싶을 경우 아래와 같이 사용

```kotlin
allprojects {
    // ...
    group = project.property("group").toString() // 이때 문자열 "group"은 gradle.properties에 정의된 key
}
```

> group, version의 경우 따로 `build.gradle.kts`에서 직접 설정하지 않아도 자동으로 설정되는 것으로 보여짐

### 멀티 모듈 설정

멀티 모듈 디랙토리를 생성 후 `settings.gradle.kts` 파일에 멀티 모듈 설정 추가

```kotlin
include(
    "sandbox-core",
    "sandbox-feign-module",
    "sandbox-web",
)
```

프로젝트 `build.gradle.kts`에서 원하는 모듈 별로 의존성 관리

```kotlin
// 각각의 모듈을 프로젝트로 관리 가능
val coreProject = project(":sandbox-core")
val feignProject = project(":sandbox-feign-module")
val webProject = project(":sandbox-web")

// 동일한 의존성을 여러 프로젝트(모듈)에 적용하고 싶은 경우
val springProjects = listOf(
    feignProject,
    webProject,
)
```

멀티 모듈을 적용할 경우 전체 프로젝트(모듈)에 적용할 설정에 대해서는 `allprojects` 함수를 사용하여서 설정. 하위 프로젝트(모듈)에 적용할 경우 `subprojects` 함수를 사용하여서 설정

특정 프로젝트에 대해서만 적용할 경우 `configure` 함수를 사용하여서 적용
