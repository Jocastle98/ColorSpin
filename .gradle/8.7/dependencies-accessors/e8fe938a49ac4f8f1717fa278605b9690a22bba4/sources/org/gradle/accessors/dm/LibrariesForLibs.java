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
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final ScalaLibraryAccessors laccForScalaLibraryAccessors = new ScalaLibraryAccessors(owner);
    private final ScalatestLibraryAccessors laccForScalatestLibraryAccessors = new ScalatestLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>guava</b> with <b>com.google.guava:guava</b> coordinates and
     * with version reference <b>guava</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGuava() {
        return create("guava");
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>scala</b>
     */
    public ScalaLibraryAccessors getScala() {
        return laccForScalaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>scalatest</b>
     */
    public ScalatestLibraryAccessors getScalatest() {
        return laccForScalatestLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class JunitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final JunitV4LibraryAccessors laccForJunitV4LibraryAccessors = new JunitV4LibraryAccessors(owner);

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("junit");
        }

        /**
         * Group of libraries at <b>junit.v4</b>
         */
        public JunitV4LibraryAccessors getV4() {
            return laccForJunitV4LibraryAccessors;
        }

    }

    public static class JunitV4LibraryAccessors extends SubDependencyFactory {
        private final JunitV4V13LibraryAccessors laccForJunitV4V13LibraryAccessors = new JunitV4V13LibraryAccessors(owner);

        public JunitV4LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>junit.v4.v13</b>
         */
        public JunitV4V13LibraryAccessors getV13() {
            return laccForJunitV4V13LibraryAccessors;
        }

    }

    public static class JunitV4V13LibraryAccessors extends SubDependencyFactory {
        private final JunitV4V13V2LibraryAccessors laccForJunitV4V13V2LibraryAccessors = new JunitV4V13V2LibraryAccessors(owner);

        public JunitV4V13LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>junit.v4.v13.v2</b>
         */
        public JunitV4V13V2LibraryAccessors getV2() {
            return laccForJunitV4V13V2LibraryAccessors;
        }

    }

    public static class JunitV4V13V2LibraryAccessors extends SubDependencyFactory {

        public JunitV4V13V2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>v13</b> with <b>org.scalatestplus:junit-4-13_2.13</b> coordinates and
         * with version reference <b>junit.v4.v13.v2.v13</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV13() {
            return create("junit.v4.v13.v2.v13");
        }

    }

    public static class ScalaLibraryAccessors extends SubDependencyFactory {
        private final ScalaXmlLibraryAccessors laccForScalaXmlLibraryAccessors = new ScalaXmlLibraryAccessors(owner);

        public ScalaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>library</b> with <b>org.scala-lang:scala-library</b> coordinates and
         * with version reference <b>scala.library</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLibrary() {
            return create("scala.library");
        }

        /**
         * Group of libraries at <b>scala.xml</b>
         */
        public ScalaXmlLibraryAccessors getXml() {
            return laccForScalaXmlLibraryAccessors;
        }

    }

    public static class ScalaXmlLibraryAccessors extends SubDependencyFactory {
        private final ScalaXmlV2LibraryAccessors laccForScalaXmlV2LibraryAccessors = new ScalaXmlV2LibraryAccessors(owner);

        public ScalaXmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>scala.xml.v2</b>
         */
        public ScalaXmlV2LibraryAccessors getV2() {
            return laccForScalaXmlV2LibraryAccessors;
        }

    }

    public static class ScalaXmlV2LibraryAccessors extends SubDependencyFactory {

        public ScalaXmlV2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>v13</b> with <b>org.scala-lang.modules:scala-xml_2.13</b> coordinates and
         * with version reference <b>scala.xml.v2.v13</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV13() {
            return create("scala.xml.v2.v13");
        }

    }

    public static class ScalatestLibraryAccessors extends SubDependencyFactory {
        private final ScalatestV2LibraryAccessors laccForScalatestV2LibraryAccessors = new ScalatestV2LibraryAccessors(owner);

        public ScalatestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>scalatest.v2</b>
         */
        public ScalatestV2LibraryAccessors getV2() {
            return laccForScalatestV2LibraryAccessors;
        }

    }

    public static class ScalatestV2LibraryAccessors extends SubDependencyFactory {

        public ScalatestV2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>v13</b> with <b>org.scalatest:scalatest_2.13</b> coordinates and
         * with version reference <b>scalatest.v2.v13</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV13() {
            return create("scalatest.v2.v13");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final ScalaVersionAccessors vaccForScalaVersionAccessors = new ScalaVersionAccessors(providers, config);
        private final ScalatestVersionAccessors vaccForScalatestVersionAccessors = new ScalatestVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>guava</b> with value <b>32.1.3-jre</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGuava() { return getVersion("guava"); }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.scala</b>
         */
        public ScalaVersionAccessors getScala() {
            return vaccForScalaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.scalatest</b>
         */
        public ScalatestVersionAccessors getScalatest() {
            return vaccForScalatestVersionAccessors;
        }

    }

    public static class JunitVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final JunitV4VersionAccessors vaccForJunitV4VersionAccessors = new JunitV4VersionAccessors(providers, config);
        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("junit"); }

        /**
         * Group of versions at <b>versions.junit.v4</b>
         */
        public JunitV4VersionAccessors getV4() {
            return vaccForJunitV4VersionAccessors;
        }

    }

    public static class JunitV4VersionAccessors extends VersionFactory  {

        private final JunitV4V13VersionAccessors vaccForJunitV4V13VersionAccessors = new JunitV4V13VersionAccessors(providers, config);
        public JunitV4VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.junit.v4.v13</b>
         */
        public JunitV4V13VersionAccessors getV13() {
            return vaccForJunitV4V13VersionAccessors;
        }

    }

    public static class JunitV4V13VersionAccessors extends VersionFactory  {

        private final JunitV4V13V2VersionAccessors vaccForJunitV4V13V2VersionAccessors = new JunitV4V13V2VersionAccessors(providers, config);
        public JunitV4V13VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.junit.v4.v13.v2</b>
         */
        public JunitV4V13V2VersionAccessors getV2() {
            return vaccForJunitV4V13V2VersionAccessors;
        }

    }

    public static class JunitV4V13V2VersionAccessors extends VersionFactory  {

        public JunitV4V13V2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.v4.v13.v2.v13</b> with value <b>3.2.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getV13() { return getVersion("junit.v4.v13.v2.v13"); }

    }

    public static class ScalaVersionAccessors extends VersionFactory  {

        private final ScalaXmlVersionAccessors vaccForScalaXmlVersionAccessors = new ScalaXmlVersionAccessors(providers, config);
        public ScalaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>scala.library</b> with value <b>2.13.12</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLibrary() { return getVersion("scala.library"); }

        /**
         * Group of versions at <b>versions.scala.xml</b>
         */
        public ScalaXmlVersionAccessors getXml() {
            return vaccForScalaXmlVersionAccessors;
        }

    }

    public static class ScalaXmlVersionAccessors extends VersionFactory  {

        private final ScalaXmlV2VersionAccessors vaccForScalaXmlV2VersionAccessors = new ScalaXmlV2VersionAccessors(providers, config);
        public ScalaXmlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.scala.xml.v2</b>
         */
        public ScalaXmlV2VersionAccessors getV2() {
            return vaccForScalaXmlV2VersionAccessors;
        }

    }

    public static class ScalaXmlV2VersionAccessors extends VersionFactory  {

        public ScalaXmlV2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>scala.xml.v2.v13</b> with value <b>1.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getV13() { return getVersion("scala.xml.v2.v13"); }

    }

    public static class ScalatestVersionAccessors extends VersionFactory  {

        private final ScalatestV2VersionAccessors vaccForScalatestV2VersionAccessors = new ScalatestV2VersionAccessors(providers, config);
        public ScalatestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.scalatest.v2</b>
         */
        public ScalatestV2VersionAccessors getV2() {
            return vaccForScalatestV2VersionAccessors;
        }

    }

    public static class ScalatestV2VersionAccessors extends VersionFactory  {

        public ScalatestV2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>scalatest.v2.v13</b> with value <b>3.2.17</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getV13() { return getVersion("scalatest.v2.v13"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
