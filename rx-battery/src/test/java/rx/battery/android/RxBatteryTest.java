package rx.battery.android;

import android.app.Application;
import android.content.Intent;
import android.os.BatteryManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import rx.observers.TestSubscriber;

import static android.content.Intent.ACTION_BATTERY_CHANGED;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RxBatteryTest {
    @Test
    public void changes() throws Exception {
        Application application = RuntimeEnvironment.application;

        TestSubscriber<Intent> o = new TestSubscriber<>();
        RxBattery.changes(application).subscribe(o);
        o.assertValues();

        Intent intent1 = new Intent(ACTION_BATTERY_CHANGED) //
                .putExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_COLD);

        application.sendBroadcast(intent1);
        o.assertValues(intent1);

        Intent intent2 = new Intent(ACTION_BATTERY_CHANGED) //
                .putExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_UNKNOWN);

        application.sendBroadcast(intent2);
        o.assertValues(intent1, intent2);
    }
}
