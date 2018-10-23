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
//作成日: 2018/10/23

package jp.co.primebrains;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Masatomi KINO
 * @version $Revision$
 */
@Slf4j
public class ServerThread extends Thread {
    private Random random;

    private RequestQueue queue;

    public ServerThread(RequestQueue queue, String name, long seed) {
        super(name);
        this.queue = queue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = queue.getRequest();
            log.info("handles {}", request);
            sleep(random.nextInt(1000));
        }

    }

    private void sleep(int interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }
}
