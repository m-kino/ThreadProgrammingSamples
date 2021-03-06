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

import lombok.extern.slf4j.Slf4j;

/**
 * @author Masatomi KINO
 * @version $Revision$
 */
@Slf4j
public class Host {
    public IData request(final int count, final char c) {
        log.debug("request :{},{} 開始", count, c);

        final FutureData futureData = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData data = new RealData(count, c);
                // setIDataでも、イイかも。
                futureData.setRealData(data);
            }
        }.start();
        log.debug("request :{},{} 終了", count, c);
        return futureData;
    }

}
