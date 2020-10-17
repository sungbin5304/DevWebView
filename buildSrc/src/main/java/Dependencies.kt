import org.gradle.api.JavaVersion

object Application {
    const val minSdk = 23
    const val targetSdk = 30
    const val compileSdk = 30
    const val jvmTarget = "1.8"
    const val versionCode = 1
    const val versionName = "1.0.0"

    val targetCompat = JavaVersion.VERSION_1_8
    val sourceCompat = JavaVersion.VERSION_1_8
}

object Versions {
    object Essential {
        const val AppCompat = "1.2.0"
        const val Anko = "0.10.8"
        const val Kotlin = "1.4.10"
        const val Gradle = "4.1.0"
    }

    object Ktx {
        const val Core = "1.3.2"
    }

    object Ui {
        const val Material = "1.2.1"
        const val ConstraintLayout = "2.0.2"
    }

    object Util {
        const val AndroidUtils = "4.0.4"
        const val CarshReporter = "1.1.0"
    }
}

object Dependencies {
    object Essential {
        const val AppCompat = "androidx.appcompat:appcompat:${Versions.Essential.AppCompat}"
        const val Anko = "org.jetbrains.anko:anko:${Versions.Essential.Anko}"
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Essential.Kotlin}"
    }

    object Ktx {
        const val Core = "androidx.core:core-ktx:${Versions.Ktx.Core}"
    }

    object Ui {
        const val Material = "com.google.android.material:material:${Versions.Ui.Material}"
        const val ConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.Ui.ConstraintLayout}"
    }

    object Util {
        const val AndroidUtils = "com.github.sungbin5304:SBT:${Versions.Util.AndroidUtils}"
        const val CrashReporter =
            "com.balsikandar.android:crashreporter:${Versions.Util.CarshReporter}"
    }
}