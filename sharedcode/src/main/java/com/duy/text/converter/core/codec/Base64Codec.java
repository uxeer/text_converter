/*
 * Copyright (c) 2017 by Tran Le Duy
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

package com.duy.text.converter.core.codec;

import android.support.annotation.NonNull;
import android.util.Base64;

import com.duy.text.converter.core.codec.interfaces.CodecImpl;

import java.nio.charset.Charset;

/**
 * Created by Duy on 22-Jun-17.
 */

public class Base64Codec extends CodecImpl {
    @NonNull
    @Override
    public String encode(@NonNull String token) {
        setMax(1);
        try {
            byte[] encodedBytes = Base64.encode(token.getBytes(), Base64.DEFAULT);
            String result = new String(encodedBytes, Charset.forName("UTF-8"));
            setConfident(1);
            return result;
        } catch (Exception e) {
            setConfident(0);
            return token;
        }
    }

    @NonNull
    @Override
    public String decode(@NonNull String token) {
        setMax(1);
        try {
            byte[] decodedBytes = Base64.decode(token.getBytes(), Base64.DEFAULT);
            String result = new String(decodedBytes, Charset.forName("UTF-8"));
            setConfident(1);
            return result;
        } catch (Exception e) {
            setConfident(0);
            return token;
        }
    }


}
