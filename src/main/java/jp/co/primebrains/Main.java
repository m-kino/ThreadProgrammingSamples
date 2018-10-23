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

/**
 * @author Masatomi KINO
 * @version $Revision$
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "Alice", 111111L).start();
        sleep(1000);
        new ServerThread(queue, "Bobby", 333333L).start();

    }

    private static void sleep(int interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }
}
