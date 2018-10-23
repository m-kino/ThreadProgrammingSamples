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

import java.util.LinkedList;

/**
 * @author Masatomi KINO
 * @version $Revision$
 */
public class RequestQueue {
    private LinkedList<Request> queue = new LinkedList<Request>();

    public Request getRequest() {
        return queue.removeFirst();
    }

    public void putRequest(Request request) {
        queue.addLast(request);
    }

}
