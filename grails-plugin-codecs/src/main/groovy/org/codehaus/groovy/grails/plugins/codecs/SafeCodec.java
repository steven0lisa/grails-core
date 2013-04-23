/* Copyright 2013 the original author or authors.
 *
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
 */
package org.codehaus.groovy.grails.plugins.codecs;

import java.io.IOException;

import org.codehaus.groovy.grails.support.encoding.CodecIdentifier;
import org.codehaus.groovy.grails.support.encoding.Decoder;
import org.codehaus.groovy.grails.support.encoding.DefaultCodecIdentifier;
import org.codehaus.groovy.grails.support.encoding.EncodedAppender;
import org.codehaus.groovy.grails.support.encoding.Encoder;
import org.codehaus.groovy.grails.support.encoding.EncodingState;
import org.codehaus.groovy.grails.support.encoding.StreamingEncoder;

/**
 * Codec that doesn't do any encoding or decoding. This is for marking some text
 * as "safe" in the buffer. "safe" part of the buffer won't be encoded later if
 * a codec is applied to the buffer
 * 
 * @author Lari Hotari
 * @since 2.3
 */
public class SafeCodec implements Encoder, Decoder, StreamingEncoder {
    static final CodecIdentifier SAFE_CODEC_IDENTIFIER = new DefaultCodecIdentifier("Safe", "Raw");

    /*
     * (non-Javadoc)
     * @see
     * org.codehaus.groovy.grails.support.encoding.Decoder#decode(java.lang.
     * Object)
     */
    public Object decode(Object o) {
        return o;
    }

    /*
     * (non-Javadoc)
     * @see org.codehaus.groovy.grails.support.encoding.Encoder#isSafe()
     */
    public boolean isSafe() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.codehaus.groovy.grails.support.encoding.Encoder#encode(java.lang.
     * Object)
     */
    public Object encode(Object o) {
        return o;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.codehaus.groovy.grails.support.encoding.Encoder#markEncoded(java.
     * lang.CharSequence)
     */
    public void markEncoded(CharSequence string) {

    }

    /*
     * (non-Javadoc)
     * @see
     * org.codehaus.groovy.grails.support.encoding.StreamingEncoder#encodeToStream
     * (java.lang.CharSequence, int, int,
     * org.codehaus.groovy.grails.support.encoding.EncodedAppender,
     * org.codehaus.groovy.grails.support.encoding.EncodingState)
     */
    public void encodeToStream(CharSequence source, int offset, int len, EncodedAppender appender,
            EncodingState encodingState) throws IOException {
        appender.appendEncoded(this, encodingState, source, offset, len);
    }

    /*
     * (non-Javadoc)
     * @see org.codehaus.groovy.grails.support.encoding.CodecIdentifierProvider#
     * getCodecIdentifier()
     */
    public CodecIdentifier getCodecIdentifier() {
        return SAFE_CODEC_IDENTIFIER;
    }
}
