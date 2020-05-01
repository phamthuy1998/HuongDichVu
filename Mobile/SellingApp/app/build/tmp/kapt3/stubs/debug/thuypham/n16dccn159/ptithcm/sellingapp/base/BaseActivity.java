package thuypham.n16dccn159.ptithcm.sellingapp.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u001c\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068WX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lthuypham/n16dccn159/ptithcm/sellingapp/base/BaseActivity;", "ViewBinding", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "layoutId", "", "getLayoutId", "()I", "toolbarLayoutId", "getToolbarLayoutId", "viewBinding", "getViewBinding", "()Landroidx/databinding/ViewDataBinding;", "setViewBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "bindView", "", "bindViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupToolbar", "toolbarFunc", "curActivity", "Landroid/app/Activity;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "app_debug"})
public abstract class BaseActivity<ViewBinding extends androidx.databinding.ViewDataBinding> extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public ViewBinding viewBinding;
    private final int toolbarLayoutId = -1;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final ViewBinding getViewBinding() {
        return null;
    }
    
    public final void setViewBinding(@org.jetbrains.annotations.NotNull()
    ViewBinding p0) {
    }
    
    @androidx.annotation.LayoutRes()
    public abstract int getLayoutId();
    
    @androidx.annotation.LayoutRes()
    public int getToolbarLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    public void toolbarFunc(@org.jetbrains.annotations.Nullable()
    android.app.Activity curActivity, @org.jetbrains.annotations.Nullable()
    androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    public void bindView() {
    }
    
    public void bindViewModel() {
    }
    
    public BaseActivity() {
        super();
    }
}