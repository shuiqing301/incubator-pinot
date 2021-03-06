/**
 * Copyright (C) 2014-2018 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.linkedin.thirdeye.alert.commons;

import com.linkedin.thirdeye.datalayer.util.StringUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class AnomalyFeedConfig {
  private String anomalyFeedType;
  private AnomalySource anomalySourceType;
  private String anomalySource;
  private Long alertSnapshotId;
  private List<AnomalyFetcherConfig> anomalyFetcherConfigs;
  private List<Map<String, String>> alertFilterConfigs;

  public String getAnomalyFeedType() {
    return anomalyFeedType;
  }

  public void setAnomalyFeedType(String anomalyFeedType) {
    this.anomalyFeedType = anomalyFeedType;
  }

  public AnomalySource getAnomalySourceType() {
    return anomalySourceType;
  }

  public void setAnomalySourceType(AnomalySource anomalySourceType) {
    this.anomalySourceType = anomalySourceType;
  }

  public String getAnomalySource() {
    return anomalySource;
  }

  public void setAnomalySource(String anomalySource) {
    this.anomalySource = anomalySource;
  }

  public List<AnomalyFetcherConfig> getAnomalyFetcherConfigs() {
    if (anomalyFetcherConfigs == null) {
      anomalyFetcherConfigs = Collections.emptyList();
    }
    for (AnomalyFetcherConfig anomalyFetcherConfig : anomalyFetcherConfigs) {
      Properties properties = StringUtils.decodeCompactedProperties(anomalyFetcherConfig.getProperties());
      anomalyFetcherConfig.setAnomalySourceType(anomalySourceType);
      anomalyFetcherConfig.setAnomalySource(anomalySource);
      anomalyFetcherConfig.setProperties(StringUtils.encodeCompactedProperties(properties));
    }
    return anomalyFetcherConfigs;
  }

  public void setAnomalyFetcherConfigs(List<AnomalyFetcherConfig> anomalyFetcherConfigs) {
    this.anomalyFetcherConfigs = anomalyFetcherConfigs;
  }

  public List<Map<String, String>> getAlertFilterConfigs() {
    if (alertFilterConfigs == null) {
      alertFilterConfigs = Collections.emptyList();
    }
    return alertFilterConfigs;
  }

  public void setAlertFilterConfigs(List<Map<String, String>> alertFilterConfigs) {
    this.alertFilterConfigs = alertFilterConfigs;
  }

  public Long getAlertSnapshotId() {
    return alertSnapshotId;
  }

  public void setAlertSnapshotId(Long alertSnapshotId) {
    this.alertSnapshotId = alertSnapshotId;
  }
}
