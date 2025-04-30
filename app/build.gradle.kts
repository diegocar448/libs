plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") version "2.0.0-1.0.24"
}

android {
    namespace = "com.fit.projetofreeware"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.fit.projetofreeware"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //navegação
    implementation(libs.androidx.navigation.compose)    // code generator DI
    implementation(libs.hilt.android)
    // integração das libs hilt do android com a UI jetpack compose
    implementation(libs.androidx.hilt.navigation.compose)
    // gerar codigos para as anotações de injeção de dependencia hilt
    implementation(libs.hilt.compiler)
    implementation(libs.androidx.room.runtime)
    //kapt("androidx.room:room-compiler:2.6.1")
    // gerador de codigo para persistencia de dados, compilador do room
    ksp(libs.androidx.room.compiler)
    // ksp se estiver usando Kotlin Coroutines
    implementation(libs.androidx.room.ktx)




}

