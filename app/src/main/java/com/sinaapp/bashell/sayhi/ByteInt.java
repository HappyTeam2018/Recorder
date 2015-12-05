/******************************************************************************
 *                                                                            *
 * Copyright (c) 1999-2004 Wimba S.A., All Rights Reserved.                   *
 *                                                                            *
 * COPYRIGHT:                                                                 *
 *      This software is the property of Wimba S.A.                           *
 *      This software is redistributed under the Xiph.org variant of          *
 *      the BSD license.                                                      *
 *      Redistribution and use in source and binary forms, with or without    *
 *      modification, are permitted provided that the following conditions    *
 *      are met:                                                              *
 *      - Redistributions of source code must retain the above copyright      *
 *      notice, this list of conditions and the following disclaimer.         *
 *      - Redistributions in binary form must reproduce the above copyright   *
 *      notice, this list of conditions and the following disclaimer in the   *
 *      documentation and/or other materials provided with the distribution.  *
 *      - Neither the name of Wimba, the Xiph.org Foundation nor the names of *
 *      its contributors may be used to endorse or promote products derived   *
 *      from this software without specific prior written permission.         *
 *                                                                            *
 * WARRANTIES:                                                                *
 *      This software is made available by the authors in the hope            *
 *      that it will be useful, but without any warranty.                     *
 *      Wimba S.A. is not liable for any consequence related to the           *
 *      use of the provided software.                                         *
 *                                                                            *
 * Class: RawWriter.java                                                      *
 *                                                                            *
 * Author: Marc GIMPEL                                                        *
 *                                                                            *
 * Date: 6th January 2004                                                     *
 *                                                                            *
 ******************************************************************************/

/* $Id: AudioFileWriter.java,v 1.1 2011/12/27 04:39:13 gauss Exp $ */

package com.sinaapp.bashell.sayhi;

public abstract class ByteInt {
	public static byte[] intToByteArray(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		// ���������Ҫ��ֵŪ�����λȥ������˵����λ������Ҳ���ԣ� result[0] = (byte)(i & 0xFF000000);
		// ��������Ȼ�ѵ�һ���ֽ�ȡ�����ˣ�������ֱ��ת��Ϊbyte���ͣ��ᳬ��byte�Ľ��ޣ�����error����������//֮��ת����ԭ�򣨲����������͵��ֽڴ�С�Ƿ�һ����ԭ���ǲ��ı�ֵ���ڴ����ݿ��ܻ�䣬����intתΪ//float�϶���䣩���Դ�ʱ��intתΪbyte��Խ�磬ֻ��int��ǰ�����ֽڶ�Ϊ0��ʱ��תbyte�Ų���Խ�硣��//Ȼ
		// result[0] = (byte)(i & 0xFF000000); �������У��������ǿ������� result[0] =
		// (byte)((i & //0xFF000000) >>24);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

	public static void writeInt(byte[] data, int offset, int i) {
		data[offset + 0] = (byte) ((i >> 24) & 0xFF);
		data[offset + 1] = (byte) ((i >> 16) & 0xFF);
		data[offset + 2] = (byte) ((i >> 8) & 0xFF);
		data[offset + 3] = (byte) (i & 0xFF);
	}

	public static int readInt(byte[] b, int offset) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (b[i + offset] & 0x000000FF) << shift;// ����λ��
		}
		return value;
	}

	public static int byteArrayToInt(byte[] b, int offset) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			value |= b[i];
			value = value << 8;
		}
		return value;
	}
}
