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

/**
 * @author Masatomi KINO
 * @version $Revision$
 */
public class FutureData implements IData {
    // IDataでも、イイかも。
    private RealData realData;

    private boolean ready = false;

    // setIDataでも、イイかも。
    public synchronized void setRealData(RealData realData) {
        this.realData = realData;
        ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }

}