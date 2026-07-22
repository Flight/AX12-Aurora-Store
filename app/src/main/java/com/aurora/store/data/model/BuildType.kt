package com.aurora.store.data.model

import com.aurora.store.BuildConfig

/**
 * Class representing build types for Aurora Store
 */
enum class BuildType(val packageName: String) {
    RELEASE("com.aurora.store"),
    NIGHTLY("com.aurora.store.nightly"),
    DEBUG("com.aurora.store.debug");

    companion object {

        /**
         * Returns current build type
         */
        @Suppress("KotlinConstantConditions")
        val CURRENT: BuildType
            get() = when (BuildConfig.BUILD_TYPE) {
                "release" -> RELEASE
                "nightly" -> NIGHTLY
                else -> DEBUG
            }

        /**
         * Returns package names for all possible build types
         *
         * This fork ships under an application id of its own, so the running package is
         * added explicitly. Without it nothing this build installs is recognised as an
         * Aurora Store install, which empties the update list whenever the "Aurora only"
         * filter is on. Upstream's ids stay listed so a side-by-side Aurora Store, such as
         * the one preloaded on the AX12, is still recognised as one.
         */
        val PACKAGE_NAMES: List<String>
            get() = (entries.map { it.packageName } + BuildConfig.APPLICATION_ID).distinct()
    }
}
