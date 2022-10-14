package com.geekbrains.tests.automator

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class InitialTest {

    //Контекст нам понадобится для запуска нужных экранов и получения packageName
    private val context = ApplicationProvider.getApplicationContext<Context>()

    //Путь к классам нашего приложения, которые мы будем тестировать
    private val packageName = context.packageName

    //Убеждаемся, что uiDevice не null
    @Test
    fun test_DeviceNotNull() {
        //Класс UiDevice предоставляет доступ к вашему устройству.
        //Именно через UiDevice вы можете управлять устройством, открывать приложения
        //и находить нужные элементы на экране
        val uiDevice: UiDevice = UiDevice.getInstance(getInstrumentation())
        Assert.assertNotNull(uiDevice)
    }

    //Проверяем, что приложение существует
    @Test
    fun test_AppPackageNotNull() {
        Assert.assertNotNull(packageName)
    }

    //Проверяем, что Интент для запуска нашего приложения не null
    @Test
    fun test_MainActivityIntentNotNull() {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        Assert.assertNotNull(intent)
    }
}
