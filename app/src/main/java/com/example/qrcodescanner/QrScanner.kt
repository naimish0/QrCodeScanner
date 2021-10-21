package com.example.qrcodescanner

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.qrcodescanner.databinding.FragmentQrScannerBinding
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject


class QrScanner : Fragment() {

    var _binding:FragmentQrScannerBinding?=null
    private lateinit var qrScanIntegrator: IntentIntegrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentQrScannerBinding.inflate(inflater,container,false)
        val view=_binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setQrScanner()
        setOnClickListener()
    }
    fun setQrScanner()
    {
        qrScanIntegrator= IntentIntegrator.forSupportFragment(this)
        qrScanIntegrator.setOrientationLocked(false)
    }

    private fun setOnClickListener() {
        _binding?.btnScan?.setOnClickListener { performAction() }
    }

    private fun performAction()
    {
        qrScanIntegrator.setOrientationLocked(true)

        qrScanIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        qrScanIntegrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if (result!=null)
        {
            if (result.contents==null)
            {
                Extension.Toast(requireContext(),"no data in Qr Code")
            }
            else{
//                val jsonObject=JSONObject(result.contents)
               _binding?.label?.text=result.contents.toString()

            }
            }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}