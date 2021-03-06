/*
 * Copyright ©2018 vbill.cn.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package cn.vbill.middleware.porter.common.alert.provider;

import cn.vbill.middleware.porter.common.alert.AlertReceiver;
import cn.vbill.middleware.porter.common.client.AlertClient;

import java.util.List;

/**
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年12月30日 11:47
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年12月30日 11:47
 */
public class NormalAlertProvider implements AlertProvider {
    private final AlertClient client;

    public NormalAlertProvider(AlertClient client) {
        this.client = client;

    }

    /**
     * notice
     *
     * @date 2018/8/10 下午2:47
     * @param: [title, notice, receivers]
     * @return: boolean
     */
    public boolean notice(String title, String notice, List<AlertReceiver> receivers) {
        client.send(notice, title, receivers);
        return true;
    }

    /**
     * notice
     *
     * @date 2018/8/10 下午2:48
     * @param: [title, notice]
     * @return: boolean
     */
    public boolean notice(String title, String notice) {
        return notice(title, notice, null);
    }
}
