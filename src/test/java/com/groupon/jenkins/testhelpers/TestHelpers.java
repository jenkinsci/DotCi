/*
The MIT License (MIT)

Copyright (c) 2014, Groupon, Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.groupon.jenkins.testhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.groupon.jenkins.dynamic.buildconfiguration.configvalue.ListOrSingleValue;
import com.groupon.jenkins.dynamic.buildconfiguration.configvalue.ListValue;
import com.groupon.jenkins.dynamic.buildconfiguration.configvalue.MapValue;

public class TestHelpers {
	public static Map map(Object... keyValues) {
		HashMap out = new HashMap();
		for (int i = 0; i < keyValues.length; i++) {
			if (i % 2 != 0) {
				out.put(keyValues[i - 1], keyValues[i]);
			}
		}
		return out;
	}

	public static <T> List<T> list(T... values) {
		return Arrays.asList(values);
	}

	public static <T> ListValue<T> configList(T... values) {
		return new ListValue<T>(Arrays.asList(values));
	}

	public static ListOrSingleValue<String> configListOrSingleValue(String... values) {
		return new ListOrSingleValue(Arrays.asList(values));
	}

	public static MapValue<String, Object> configMap(Object... keyValues) {
		return new MapValue<String, Object>(map(keyValues));
	}

	public static String loadFile(String fileName) {
		InputStream stream = TestHelpers.class.getResourceAsStream(fileName);

		String payloadReq = null;
		try {
			payloadReq = IOUtils.toString(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return payloadReq;
	}

}
