package io.quarkus.liquibase.runtime;

import java.util.List;
import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

/**
 * The liquibase data source build time configuration
 */
@ConfigGroup
public final class LiquibaseDataSourceBuildTimeConfig {

    static final String DEFAULT_CHANGE_LOG = "db/changeLog.xml";

    /**
     * Creates a {@link LiquibaseDataSourceBuildTimeConfig} with default settings.
     *
     * @return {@link LiquibaseDataSourceBuildTimeConfig}
     */
    public static LiquibaseDataSourceBuildTimeConfig defaultConfig() {
        LiquibaseDataSourceBuildTimeConfig defaultConfig = new LiquibaseDataSourceBuildTimeConfig();
        defaultConfig.changeLog = DEFAULT_CHANGE_LOG;
        defaultConfig.searchPath = Optional.empty();
        defaultConfig.active = true;
        return defaultConfig;
    }

    /**
     * The liquibase change log file. All included change log files in this file are scanned and add to the projects.
     */
    @ConfigItem(defaultValue = DEFAULT_CHANGE_LOG)
    public String changeLog;

    /**
     * {@code true} to enable Liquibase for a specific data source, {@code false} otherwise.
     */
    @ConfigItem(defaultValue = "true")
    public boolean active;

    /**
     * The search path for DirectoryResourceAccessor
     */
    @ConfigItem
    public Optional<List<String>> searchPath;
}
