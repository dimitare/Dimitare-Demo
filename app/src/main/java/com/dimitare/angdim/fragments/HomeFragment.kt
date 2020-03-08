package com.dimitare.angdim.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dimitare.angdim.databinding.HomeFragmentViewBinding
import com.dimitare.angdim.fragments.viewmodels.HomeFragmentViewModel
import com.dimitare.angdim.model.ResumeError
import com.dimitare.angdim.model.ResumeResponse
import com.dimitare.angdim.services.remote.RemoteResource

class HomeFragment : BaseDaggerFragment<HomeFragmentViewModel>(){
    override val mViewModel by viewModels<HomeFragmentViewModel>()
    private lateinit var mDataBinding: HomeFragmentViewBinding
    val mAdapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = HomeFragmentViewBinding.inflate(inflater, container, false).apply {
            viewModel = mViewModel
        }
        mDataBinding.lifecycleOwner = this
        mDataBinding.viewModel?.startUpdate?.observe(viewLifecycleOwner, Observer {
        })
        mDataBinding.viewModel?.mUserResumeStatus?.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                is RemoteResource.Success<ResumeResponse, ResumeError> -> {
                }
                is RemoteResource.Error<ResumeResponse, ResumeError> -> {
                }
                is RemoteResource.Loading<ResumeResponse, ResumeError> -> {
                }
            }
        })
        return mDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDataBinding.recyclerView.apply {
            setHasFixedSize(true)

            adapter = mAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        mDataBinding.viewModel?.start()
    }

    override fun onStop() {
        super.onStop()
        mDataBinding.viewModel?.stop()
    }
}