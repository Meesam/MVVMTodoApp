
plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  kotlin("kapt")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "com.example.mvvmtodoapp"
  compileSdk = 34
  
  defaultConfig {
    applicationId = "com.example.mvvmtodoapp"
    minSdk = 27
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"
    
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }
  
  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation(platform("androidx.compose:compose-bom:2023.06.01"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
  
  
  // HILT Dependency
  implementation("com.google.dagger:hilt-android:2.44")
  kapt("com.google.dagger:hilt-android-compiler:2.44")
  
  // Kotlin COROUTINES Dependency
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
  
  // RETROFIT Dependency
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  
  // NAVIGATION Dependency
  implementation("androidx.navigation:navigation-compose:2.6.0")
  implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
  
  // VIEW MODEL, LIFE CYCLE Dependency
  val lifecycle_version = "2.6.2"
  val arch_version = "2.2.0"
  
  // ViewModel
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
  // ViewModel utilities for Compose
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
  // LiveData
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
  // Lifecycles only (without ViewModel or LiveData)
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
  // Lifecycle utilities for Compose
  implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
  
  // Saved state module for ViewModel
  implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
  
  // Annotation processor
  kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
  
  
  // optional - helpers for implementing LifecycleOwner in a Service
  implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")
  
  // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
  implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")
  
  // optional - ReactiveStreams support for LiveData
  implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")
  
  // optional - Test helpers for LiveData
  testImplementation("androidx.arch.core:core-testing:$arch_version")
  
  // optional - Test helpers for Lifecycle runtime
  testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")
  
  
  
  // Room
  implementation ("androidx.room:room-runtime:2.4.2")
  kapt ("androidx.room:room-compiler:2.4.2")
  annotationProcessor("androidx.room:room-compiler:2.4.2")
  // Kotlin Extensions and Coroutines support for Room
  implementation ("androidx.room:room-ktx:2.4.2")
  
  
}

kapt {
  correctErrorTypes = true
}

