package rx2.battery.android;

import android.app.Application;
import android.content.Intent;
import android.os.BatteryManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import io.reactivex.observers.TestObserver;

import static android.content.Intent.ACTION_BATTERY_CHANGED;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RxBatteryTest {
    @Test
    public void changes() throws Exception {
        Application application = RuntimeEnvironment.application;

        TestObserver<Intent> tester = RxBattery.changes(application).test();

        Intent intent1 = new Intent(ACTION_BATTERY_CHANGED) //
                .putExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_COLD);

        application.sendBroadcast(intent1);
        tester.assertValues(intent1);

        Intent intent2 = new Intent(ACTION_BATTERY_CHANGED) //
                .putExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_UNKNOWN);

        application.sendBroadcast(intent2);
        tester.assertValues(intent1, intent2);
    }
}