/*
 * Copyright 2013 Palantir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.typescript.services.language;

import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Corresponds to the class with the same name in languageService.ts.
 *
 * @author dcicerone
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class HighlightSpan {

    private final HighlightSpanKind kind;
    private final TextSpan textSpan;

    @JsonCreator
    public HighlightSpan(
            @JsonProperty("kind") HighlightSpanKind kind,
            @JsonProperty("textSpan") TextSpan textSpan) {
        checkNotNull(kind);
        checkNotNull(textSpan);

        this.kind = kind;
        this.textSpan = textSpan;
    }

    public HighlightSpanKind getKind() {
        return this.kind;
    }

    public TextSpan getTextSpan() {
        return this.textSpan;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("kind", this.kind)
            .add("textSpan", this.textSpan)
            .toString();
    }
}