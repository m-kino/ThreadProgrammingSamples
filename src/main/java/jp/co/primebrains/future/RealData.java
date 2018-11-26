/******************************************************************************
 * Copyright (c) 2014 Masatomi KINO and others. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *      Masatomi KINO - initial API and implementation
 * $Id$
 ******************************************************************************/
//作成日: 2018/11/26

package jp.co.primebrains.future;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 作成に時間のかかるRealDataクラス
 * 
 * @author Masatomi KINO
 * @version $Revision$
 */
@Data
@Slf4j
public class RealData implements IData {

    private String content;

    public RealData(int count, char c) {
        log.debug("RealData({},{}) 作成開始", count, c);
        char[] buffer = new char[count];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
        }
        content = new String(buffer);
        log.debug("RealData({},{}) 作成終了", count, c);

    }
}
