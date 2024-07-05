package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final ScalaLibraryAccessors laccForScalaLibraryAccessors = new ScalaLibraryAccessors(owner);
    private final ScalatestLibraryAccessors laccForScalatestLibraryAccessors = new ScalatestLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects) {
        super(config, providers, objects);
    }

        /**
         * Creates a dependency provider for guava (com.google.guava:guava)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGuava() { return create("guava"); }

    /**
     * Returns the group of libraries at junit
     */
    public JunitLibraryAccessors getJunit() { return laccForJunitLibraryAccessors; }

    /**
     * Returns the group of libraries at scala
     */
    public ScalaLibraryAccessors getScala() { return laccForScalaLibraryAccessors; }

    /**
     * Returns the group of libraries at scalatest
     */
    public ScalatestLibraryAccessors getScalatest() { return laccForScalatestLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class JunitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final JunitV4LibraryAccessors laccForJunitV4LibraryAccessors = new JunitV4LibraryAccessors(owner);

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (junit:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("junit"); }

        /**
         * Returns the group of libraries at junit.v4
         */
        public JunitV4LibraryAccessors getV4() { return laccForJunitV4LibraryAccessors; }

    }

    public static class JunitV4LibraryAccessors extends SubDependencyFactory {
        private final JunitV4V13LibraryAccessors laccForJunitV4V13LibraryAccessors = new JunitV4V13LibraryAccessors(owner);

        public JunitV4LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at junit.v4.v13
         */
        public JunitV4V13LibraryAccessors getV13() { return laccForJunitV4V13LibraryAccessors; }

    }

    public static class JunitV4V13LibraryAccessors extends SubDependencyFactory {
        private final JunitV4V13V2LibraryAccessors laccForJunitV4V13V2LibraryAccessors = new JunitV4V13V2LibraryAccessors(owner);

        public JunitV4V13LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at junit.v4.v13.v2
         */
        public JunitV4V13V2LibraryAccessors getV2() { return laccForJunitV4V13V2LibraryAccessors; }

    }

    public static class JunitV4V13V2LibraryAccessors extends SubDependencyFactory {

        public JunitV4V13V2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for v13 (org.scalatestplus:junit-4-13_2.13)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getV13() { return create("junit.v4.v13.v2.v13"); }

    }

    public static class ScalaLibraryAccessors extends SubDependencyFactory {
        private final ScalaXmlLibraryAccessors laccForScalaXmlLibraryAccessors = new ScalaXmlLibraryAccessors(owner);

        public ScalaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for library (org.scala-lang:scala-library)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLibrary() { return create("scala.library"); }

        /**
         * Returns the group of libraries at scala.xml
         */
        public ScalaXmlLibraryAccessors getXml() { return laccForScalaXmlLibraryAccessors; }

    }

    public static class ScalaXmlLibraryAccessors extends SubDependencyFactory {
        private final ScalaXmlV2LibraryAccessors laccForScalaXmlV2LibraryAccessors = new ScalaXmlV2LibraryAccessors(owner);

        public ScalaXmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at scala.xml.v2
         */
        public ScalaXmlV2LibraryAccessors getV2() { return laccForScalaXmlV2LibraryAccessors; }

    }

    public static class ScalaXmlV2LibraryAccessors extends SubDependencyFactory {

        public ScalaXmlV2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for v13 (org.scala-lang.modules:scala-xml_2.13)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getV13() { return create("scala.xml.v2.v13"); }

    }

    public static class ScalatestLibraryAccessors extends SubDependencyFactory {
        private final ScalatestV2LibraryAccessors laccForScalatestV2LibraryAccessors = new ScalatestV2LibraryAccessors(owner);

        public ScalatestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at scalatest.v2
         */
        public ScalatestV2LibraryAccessors getV2() { return laccForScalatestV2LibraryAccessors; }

    }

    public static class ScalatestV2LibraryAccessors extends SubDependencyFactory {

        public ScalatestV2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for v13 (org.scalatest:scalatest_2.13)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getV13() { return create("scalatest.v2.v13"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final ScalaVersionAccessors vaccForScalaVersionAccessors = new ScalaVersionAccessors(providers, config);
        private final ScalatestVersionAccessors vaccForScalatestVersionAccessors = new ScalatestVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: guava (32.1.3-jre)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGuava() { return getVersion("guava"); }

        /**
         * Returns the group of versions at versions.junit
         */
        public JunitVersionAccessors getJunit() { return vaccForJunitVersionAccessors; }

        /**
         * Returns the group of versions at versions.scala
         */
        public ScalaVersionAccessors getScala() { return vaccForScalaVersionAccessors; }

        /**
         * Returns the group of versions at versions.scalatest
         */
        public ScalatestVersionAccessors getScalatest() { return vaccForScalatestVersionAccessors; }

    }

    public static class JunitVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final JunitV4VersionAccessors vaccForJunitV4VersionAccessors = new JunitV4VersionAccessors(providers, config);
        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: junit (4.13.2)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("junit"); }

        /**
         * Returns the group of versions at versions.junit.v4
         */
        public JunitV4VersionAccessors getV4() { return vaccForJunitV4VersionAccessors; }

    }

    public static class JunitV4VersionAccessors extends VersionFactory  {

        private final JunitV4V13VersionAccessors vaccForJunitV4V13VersionAccessors = new JunitV4V13VersionAccessors(providers, config);
        public JunitV4VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.junit.v4.v13
         */
        public JunitV4V13VersionAccessors getV13() { return vaccForJunitV4V13VersionAccessors; }

    }

    public static class JunitV4V13VersionAccessors extends VersionFactory  {

        private final JunitV4V13V2VersionAccessors vaccForJunitV4V13V2VersionAccessors = new JunitV4V13V2VersionAccessors(providers, config);
        public JunitV4V13VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.junit.v4.v13.v2
         */
        public JunitV4V13V2VersionAccessors getV2() { return vaccForJunitV4V13V2VersionAccessors; }

    }

    public static class JunitV4V13V2VersionAccessors extends VersionFactory  {

        public JunitV4V13V2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: junit.v4.v13.v2.v13 (3.2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getV13() { return getVersion("junit.v4.v13.v2.v13"); }

    }

    public static class ScalaVersionAccessors extends VersionFactory  {

        private final ScalaXmlVersionAccessors vaccForScalaXmlVersionAccessors = new ScalaXmlVersionAccessors(providers, config);
        public ScalaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: scala.library (2.13.12)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLibrary() { return getVersion("scala.library"); }

        /**
         * Returns the group of versions at versions.scala.xml
         */
        public ScalaXmlVersionAccessors getXml() { return vaccForScalaXmlVersionAccessors; }

    }

    public static class ScalaXmlVersionAccessors extends VersionFactory  {

        private final ScalaXmlV2VersionAccessors vaccForScalaXmlV2VersionAccessors = new ScalaXmlV2VersionAccessors(providers, config);
        public ScalaXmlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.scala.xml.v2
         */
        public ScalaXmlV2VersionAccessors getV2() { return vaccForScalaXmlV2VersionAccessors; }

    }

    public static class ScalaXmlV2VersionAccessors extends VersionFactory  {

        public ScalaXmlV2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: scala.xml.v2.v13 (1.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getV13() { return getVersion("scala.xml.v2.v13"); }

    }

    public static class ScalatestVersionAccessors extends VersionFactory  {

        private final ScalatestV2VersionAccessors vaccForScalatestV2VersionAccessors = new ScalatestV2VersionAccessors(providers, config);
        public ScalatestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.scalatest.v2
         */
        public ScalatestV2VersionAccessors getV2() { return vaccForScalatestV2VersionAccessors; }

    }

    public static class ScalatestV2VersionAccessors extends VersionFactory  {

        public ScalatestV2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: scalatest.v2.v13 (3.2.17)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getV13() { return getVersion("scalatest.v2.v13"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
