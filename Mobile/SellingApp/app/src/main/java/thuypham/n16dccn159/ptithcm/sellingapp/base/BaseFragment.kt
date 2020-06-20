package thuypham.n16dccn159.ptithcm.sellingapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class BaseFragment<ViewBinding : ViewDataBinding> : Fragment() {
    lateinit var viewBinding: ViewBinding
    @get:LayoutRes
    abstract val layoutId: Int
    @get:LayoutRes
    open val toolbarLayoutId: Int = -1
    open val isBlackStatusBar: Boolean = false

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        (requireActivity() as? AppCompatActivity)?.isBlackStatusBar(isBlackStatusBar)
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        viewBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
//        view.setAutoHideKeyboard(requireActivity())

//        setUpToolbar()
        initView()
        bindEvent()
        bindViewModel()
    }

//    fun setUpToolbar(toolbarLayoutId: Int = this.toolbarLayoutId) {
//        if (toolbarLayoutId == -1) return
//        (activity as? BaseActivity<*>)?.addToolbar(
//            toolbarLayoutId = toolbarLayoutId,
//            viewGroup = (activity as? BaseActivity<*>)?.viewBinding?.root as? ViewGroup,
//            toolbarCallBack = { curActivity, toolbar ->
//                toolbarFunc(curActivity, toolbar)
//            })
//    }
//
//    fun removeToolbar() {
//        (activity as? BaseActivity<*>)?.removeToolbar()
//    }

    open fun toolbarFunc(curActivity: AppCompatActivity?, toolbar: Toolbar?) {}
    open fun bindViewModel() {}
    open fun bindEvent() {}
    open fun initView() {}

}