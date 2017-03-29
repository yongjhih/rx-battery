/*
 * Copyright (C) 2017, Andrew Chen
 *
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
 */
package rx2.battery.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import rx2.receiver.android.RxReceiver;

public final class RxBattery {
    private RxBattery() {
        throw new AssertionError("no instances");
    }

    /**
     * Usage:
     *
     * <pre>
     * BatteryChangedEvent.builder()
     *     .health(intent.getIntExtra(BatteryManager.EXTRA_HEALTH,
     *         BatteryManager.BATTERY_HEALTH_UNKNOWN))
     *     .smallIcon(intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, -1))
     *     .level(intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1))
     *     .plugged(intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1))
     *     .present(intent.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false))
     *     .scale(intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1))
     *     .status(intent.getIntExtra(BatteryManager.EXTRA_STATUS,
     *         BatteryManager.BATTERY_STATUS_UNKNOWN))
     *     .technology(intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY))
     *     .temperature(intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1))
     *     .voltage(intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1))
     *     .build();
     * </pre>
     *
     * TODO Move Battery battery-models module
     *
     * @param context
     * @return
     */
    @CheckReturnValue
    @NonNull
    public static Observable<Intent> changes(@NonNull final Context context) {
        return RxReceiver.receives(context, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
