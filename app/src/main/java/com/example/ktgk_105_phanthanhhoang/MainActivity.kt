
package com.example.ktgk_105_phanthanhhoang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var edtTenKhoanChi_105: EditText
    private lateinit var edtSoTien_105: EditText
    private lateinit var edtGhiChu_105: EditText
    private lateinit var btnThemKhoanChi_105: Button
    private lateinit var btnXemChiTiet_105: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.title =
            "Phan Thanh Hoang - 23115141122105 - Quản lý chi tiêu cá nhân"

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        edtTenKhoanChi_105 =
            findViewById(R.id.edtTenKhoanChi_105)
        edtSoTien_105 =
            findViewById(R.id.edtSoTien_105)
        edtGhiChu_105 =
            findViewById(R.id.edtGhiChu_105)
        btnThemKhoanChi_105 =
            findViewById(R.id.btnThemKhoanChi_105)
        btnXemChiTiet_105 =
            findViewById(R.id.btnXemChiTiet_105)

        btnThemKhoanChi_105.setOnClickListener {
            xuLyThemKhoanChi_105()
        }

        btnXemChiTiet_105.setOnClickListener {
            moChiTietKhoanChi_105()
        }
    }

    private fun xuLyThemKhoanChi_105() {
        val tenKhoanChi_105 =
            edtTenKhoanChi_105.text.toString().trim()
        val soTienText_105 =
            edtSoTien_105.text.toString().trim()
        val ghiChu_105 =
            edtGhiChu_105.text.toString().trim()

        if (tenKhoanChi_105.isEmpty()) {
            edtTenKhoanChi_105.error =
                "Vui lòng nhập tên khoản chi"
            edtTenKhoanChi_105.requestFocus()
            return
        }

        val soTien_105 = soTienText_105.toDoubleOrNull()

        if (soTien_105 == null || soTien_105 <= 0) {
            edtSoTien_105.error =
                "Số tiền phải là số lớn hơn 0"
            edtSoTien_105.requestFocus()
            return
        }

        val thongBao_105 = if (ghiChu_105.isEmpty()) {
            "Đã thêm khoản chi: $tenKhoanChi_105 - $soTien_105 VNĐ"
        } else {
            "Đã thêm khoản chi: $tenKhoanChi_105 - " +
                    "$soTien_105 VNĐ\nGhi chú: $ghiChu_105"
        }

        Toast.makeText(
            this,
            thongBao_105,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun moChiTietKhoanChi_105() {
        val tenKhoanChi_105 =
            edtTenKhoanChi_105.text.toString().trim()
        val soTienText_105 =
            edtSoTien_105.text.toString().trim()
        val ghiChu_105 =
            edtGhiChu_105.text.toString().trim()

        if (tenKhoanChi_105.isEmpty()) {
            edtTenKhoanChi_105.error =
                "Vui lòng nhập tên khoản chi"
            edtTenKhoanChi_105.requestFocus()
            return
        }

        val soTien_105 = soTienText_105.toDoubleOrNull()

        if (soTien_105 == null || soTien_105 <= 0) {
            edtSoTien_105.error =
                "Số tiền phải lớn hơn 0"
            edtSoTien_105.requestFocus()
            return
        }

        val intent_105 = Intent(
            this,
            ChiTietChiTieuActivity::class.java
        )

        intent_105.putExtra(
            "tenKhoanChi_105",
            tenKhoanChi_105
        )
        intent_105.putExtra(
            "soTien_105",
            soTienText_105
        )
        intent_105.putExtra(
            "ghiChu_105",
            ghiChu_105
        )

        startActivity(intent_105)
    }
}
