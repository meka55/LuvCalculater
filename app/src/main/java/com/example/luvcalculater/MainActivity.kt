package com.example.luvcalculater
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.luvcalculater.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var fname:String = "nu              ll"
    var sname:String = "null"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }
    private fun initClicker() {
        with(binding) {
            calculateBtn.setOnClickListener {
                fname = binding.fnameEt.text.toString()
                sname = binding.snameEt.text.toString()

                App.api.getCalculateLove(fnameEt.text.toString(), snameEt.text.toString())
                    .enqueue(object : Callback<LuvModel> {
                        override fun onResponse(
                            call: Call<LuvModel>,
                            response: Response<LuvModel>
                        ) {
                            if (response.isSuccessful){
                                Log.e("livai", "onResponse: ${response.body()?.result}", )
                                val model = response.body()
                                val intent: Intent = Intent(this@MainActivity,ResultActivity::class.java)
                                intent.putExtra("key", fname)
                                intent.putExtra("key1", sname)
                                intent.putExtra("key2", model?.percentage.toString())
                                startActivity(intent)
                            }

                        }
                        override fun onFailure(call: Call<LuvModel>, t: Throwable) {
                            Log.e("livai", "onFailure: ${t.message}", )
                        }

                    })

            }
        }
    }
}