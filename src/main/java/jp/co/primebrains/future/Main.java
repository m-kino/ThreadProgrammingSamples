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
public class Main {
    public static void main(String[] args) {
        log.debug("Main start.");
        Host host = new Host();
        IData data1 = host.request(10, 'A');
        IData data2 = host.request(20, 'B');
        IData data3 = host.request(30, 'C');

        log.debug("メインスレッドの時間がかかる処理開始");
        execute(); // ココの処理はdata1,data2,data3をつかわないので、先にやっちゃいたい
        log.debug("メインスレッドの時間がかかる処理終了");

        // 実際にdata1,data2,data3をつかうのはココ。
        log.debug("data1= {}", data1.getContent());
        log.debug("data2= {}", data2.getContent());
        log.debug("data3= {}", data3.getContent());

        log.debug("Main end.");
    }

    // なんか時間がかかる処理
    private static void execute() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

}
