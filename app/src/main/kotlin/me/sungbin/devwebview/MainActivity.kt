package me.sungbin.devwebview

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActionBarDrawerToggle(this, dl_drawer, toolbar, R.string.open, R.string.close).run {
            syncState()
        }

        nv_navigation.getHeaderView(0).findViewById<TextView>(R.id.tv_title).text = "AAAAAAA"

        webview.run {
            webViewClient = WebViewClient()
            settings.run {
                javaScriptEnabled = true
                javaScriptCanOpenWindowsAutomatically = false
                loadWithOverviewMode = true
                useWideViewPort = true
                builtInZoomControls = true
                domStorageEnabled = true
                layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
                cacheMode = WebSettings.LOAD_NO_CACHE
                setSupportMultipleWindows(false)
                setSupportZoom(true)
            }
            loadUrl("https://google.com")
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
        }

        /*val btn = findViewById<View>(R.id.btn) as Button
        btn.setOnClickListener { mWebView!!.loadUrl(edtUrl.text.toString()) }
        val btn2 = findViewById<View>(R.id.btn2) as Button
        btn2.setOnClickListener { mWebView!!.loadUrl("javascript:var script = document.createElement('script'); script.src=\"//cdn.jsdelivr.net/npm/eruda\"; document.body.appendChild(script); script.onload = function () { eruda.init() };") }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.run {
            maxWidth = Integer.MAX_VALUE
            queryHint = getString(R.string.main_input_address)
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setIconifiedByDefault(true)
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(string: String?): Boolean {
                    if (!string.isNullOrBlank()) webview.loadUrl(string)
                    return false
                }

                override fun onQueryTextChange(str: String?): Boolean {
                    return false
                }

            })
            return true
        }
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) webview.goBack()
        else super.onBackPressed()
    }
}