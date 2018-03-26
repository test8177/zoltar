/*-
 * -\-\-
 * zoltar-core
 * --
 * Copyright (C) 2016 - 2018 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.zoltar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.hamcrest.core.Is;
import org.junit.Test;

public class FeatureExtractorTest {

  @Test
  public void emptyExtract() throws Exception {
    final List<Vector<Object, Object>> vectors = FeatureExtractor
        .create(inputs -> Collections.emptyList())
        .extract();

    assertThat(vectors.size(), Is.is(0));
  }

  @Test
  public void nonEmptyExtract() throws Exception {
    final List<Vector<Integer, Float>> vectors =
        FeatureExtractor.<Integer, Float>create(inputs -> {
          return Arrays.stream(inputs)
              .map(i -> (float) i / 10)
              .collect(Collectors.toList());
        }).extract(1);

    assertThat(vectors.size(), is(1));
    assertThat(vectors.get(0), is(Vector.create(1, 0.1f)));

  }
}