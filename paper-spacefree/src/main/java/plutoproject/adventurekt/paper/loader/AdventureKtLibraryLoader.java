package plutoproject.adventurekt.paper.loader;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;

import java.util.List;

public class AdventureKtLibraryLoader implements PluginLoader {

    private final static List<String> LIBRARIES = List.of(
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.1.20",
            "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.10.2"
    );

    @Override
    public void classloader(PluginClasspathBuilder classpathBuilder) {
        MavenLibraryResolver resolver = new MavenLibraryResolver();

        for (String dependency : LIBRARIES) {
            resolver.addDependency(
                    new Dependency(
                            new DefaultArtifact(dependency),
                            null
                    )
            );
        }

        classpathBuilder.addLibrary(resolver);
    }

}
