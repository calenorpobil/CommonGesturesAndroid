package com.ebookfrenzy.commongestures

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ebookfrenzy.commongestures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener


{


    /**
     * ONTOUCHEVENT
     *
     * Todos los gestos tienen que pasar por aquí.
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        this.gDetector?.onTouchEvent(event)
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event)
    }

    private lateinit var binding: ActivityMainBinding
    var gDetector: GestureDetector? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Dado que esto solo debe realizarse una vez en el momento en que
        //se crea la actividad, el mejor lugar para crear la instancia de GestureDetector
        //es el método onCreate():
        this.gDetector = GestureDetector(this, this)
        gDetector?.setOnDoubleTapListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onDown(event: MotionEvent): Boolean {

        binding.gestureStatusText.text = "onDown"

        //El true indica al marco de trabajo de Android que el método ha consumido el
        //evento y no es necesario pasarlo al siguiente controlador de eventos de la pila.
        return true

    }






    override fun onLongPress(event: MotionEvent) {

        binding.gestureStatusText.text = "onLongPress"

    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        binding.gestureStatusText.text = "onFling"
        return true
    }





    override fun onShowPress(event: MotionEvent) {

        binding.gestureStatusText.text = "onShowPress"

    }



    override fun onSingleTapUp(event: MotionEvent): Boolean {

        binding.gestureStatusText.text = "onSingleTapUp"

        return true

    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        binding.gestureStatusText.text = "onScroll"
        return true
    }


    override fun onDoubleTap(event: MotionEvent): Boolean {

        binding.gestureStatusText.text = "onDoubleTap"
        return true
    }



    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        binding.gestureStatusText.text = "onDoubleTapEvent"
        return true
    }


    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        binding.gestureStatusText.text = "onSingleTapConfirmed"
        return true
    }
}