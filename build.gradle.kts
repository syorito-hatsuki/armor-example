val javaVersion = JavaVersion.VERSION_21
val minecraftVersion: String by project
val modVersion: String by project
val mavenGroup: String by project
val modId: String by project

plugins {
    id("fabric-loom")
}

base {
    archivesName.set("$modId-$modVersion-$minecraftVersion")
}

repositories {

}

dependencies {
    minecraft("com.mojang", "minecraft", minecraftVersion)

    val yarnMappings: String by project
    mappings("net.fabricmc", "yarn", yarnMappings, null, "v2")

    val loaderVersion: String by project
    modImplementation("net.fabricmc", "fabric-loader", loaderVersion)

    val fabricVersion: String by project
    modImplementation("net.fabricmc.fabric-api", "fabric-api", fabricVersion)
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }

    jar {
        from("LICENSE")
    }

    processResources {
        val modName: String by project

        filesMatching("fabric.mod.json") {
            expand(
                mutableMapOf(
                    "modId" to modId,
                    "modName" to modName,
                    "modVersion" to modVersion,
                    "minecraftVersion" to minecraftVersion,
                    "javaVersion" to javaVersion.toString()
                )
            )
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
        }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
}
