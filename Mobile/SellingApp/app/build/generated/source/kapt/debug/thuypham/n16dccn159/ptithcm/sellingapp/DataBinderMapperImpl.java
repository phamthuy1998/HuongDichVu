package thuypham.n16dccn159.ptithcm.sellingapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityEditProfileBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityOrderDetailBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityProductDetailBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityProductInCategoryBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.BottomSheetAddCartBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentAddressCartBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentConfirmOrderBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentForgotPasswordBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentLoginBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentSignInUpBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentSignUpBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentUserBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemCategoryBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemOrderBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemOrderStatusBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductCartBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductConfirmBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductOrderBindingImpl;
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductSaleBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYEDITPROFILE = 1;

  private static final int LAYOUT_ACTIVITYORDERDETAIL = 2;

  private static final int LAYOUT_ACTIVITYPRODUCTDETAIL = 3;

  private static final int LAYOUT_ACTIVITYPRODUCTINCATEGORY = 4;

  private static final int LAYOUT_BOTTOMSHEETADDCART = 5;

  private static final int LAYOUT_FRAGMENTADDRESSCART = 6;

  private static final int LAYOUT_FRAGMENTCONFIRMORDER = 7;

  private static final int LAYOUT_FRAGMENTFORGOTPASSWORD = 8;

  private static final int LAYOUT_FRAGMENTLOGIN = 9;

  private static final int LAYOUT_FRAGMENTSIGNINUP = 10;

  private static final int LAYOUT_FRAGMENTSIGNUP = 11;

  private static final int LAYOUT_FRAGMENTUSER = 12;

  private static final int LAYOUT_ITEMCATEGORY = 13;

  private static final int LAYOUT_ITEMORDER = 14;

  private static final int LAYOUT_ITEMORDERSTATUS = 15;

  private static final int LAYOUT_ITEMPRODUCT = 16;

  private static final int LAYOUT_ITEMPRODUCTCART = 17;

  private static final int LAYOUT_ITEMPRODUCTCONFIRM = 18;

  private static final int LAYOUT_ITEMPRODUCTORDER = 19;

  private static final int LAYOUT_ITEMPRODUCTSALE = 20;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(20);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_edit_profile, LAYOUT_ACTIVITYEDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_order_detail, LAYOUT_ACTIVITYORDERDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_product_detail, LAYOUT_ACTIVITYPRODUCTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_product_in_category, LAYOUT_ACTIVITYPRODUCTINCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.bottom_sheet_add_cart, LAYOUT_BOTTOMSHEETADDCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_address_cart, LAYOUT_FRAGMENTADDRESSCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_confirm_order, LAYOUT_FRAGMENTCONFIRMORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_forgot_password, LAYOUT_FRAGMENTFORGOTPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_sign_in_up, LAYOUT_FRAGMENTSIGNINUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_sign_up, LAYOUT_FRAGMENTSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_user, LAYOUT_FRAGMENTUSER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_category, LAYOUT_ITEMCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_order, LAYOUT_ITEMORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_order_status, LAYOUT_ITEMORDERSTATUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product, LAYOUT_ITEMPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_cart, LAYOUT_ITEMPRODUCTCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_confirm, LAYOUT_ITEMPRODUCTCONFIRM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_order, LAYOUT_ITEMPRODUCTORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_sale, LAYOUT_ITEMPRODUCTSALE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYEDITPROFILE: {
          if ("layout/activity_edit_profile_0".equals(tag)) {
            return new ActivityEditProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYORDERDETAIL: {
          if ("layout/activity_order_detail_0".equals(tag)) {
            return new ActivityOrderDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_order_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTDETAIL: {
          if ("layout/activity_product_detail_0".equals(tag)) {
            return new ActivityProductDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTINCATEGORY: {
          if ("layout/activity_product_in_category_0".equals(tag)) {
            return new ActivityProductInCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_in_category is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETADDCART: {
          if ("layout/bottom_sheet_add_cart_0".equals(tag)) {
            return new BottomSheetAddCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_add_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTADDRESSCART: {
          if ("layout/fragment_address_cart_0".equals(tag)) {
            return new FragmentAddressCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_address_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCONFIRMORDER: {
          if ("layout/fragment_confirm_order_0".equals(tag)) {
            return new FragmentConfirmOrderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_confirm_order is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFORGOTPASSWORD: {
          if ("layout/fragment_forgot_password_0".equals(tag)) {
            return new FragmentForgotPasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_forgot_password is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNINUP: {
          if ("layout/fragment_sign_in_up_0".equals(tag)) {
            return new FragmentSignInUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_in_up is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNUP: {
          if ("layout/fragment_sign_up_0".equals(tag)) {
            return new FragmentSignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTUSER: {
          if ("layout/fragment_user_0".equals(tag)) {
            return new FragmentUserBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_user is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCATEGORY: {
          if ("layout/item_category_0".equals(tag)) {
            return new ItemCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_category is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMORDER: {
          if ("layout/item_order_0".equals(tag)) {
            return new ItemOrderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_order is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMORDERSTATUS: {
          if ("layout/item_order_status_0".equals(tag)) {
            return new ItemOrderStatusBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_order_status is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPRODUCT: {
          if ("layout/item_product_0".equals(tag)) {
            return new ItemProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPRODUCTCART: {
          if ("layout/item_product_cart_0".equals(tag)) {
            return new ItemProductCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_product_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPRODUCTCONFIRM: {
          if ("layout/item_product_confirm_0".equals(tag)) {
            return new ItemProductConfirmBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_product_confirm is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPRODUCTORDER: {
          if ("layout/item_product_order_0".equals(tag)) {
            return new ItemProductOrderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_product_order is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPRODUCTSALE: {
          if ("layout/item_product_sale_0".equals(tag)) {
            return new ItemProductSaleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_product_sale is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(15);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "cartCount");
      sKeys.put(2, "category");
      sKeys.put(3, "feeShip");
      sKeys.put(4, "fragment");
      sKeys.put(5, "listStatus");
      sKeys.put(6, "order");
      sKeys.put(7, "orderStatus");
      sKeys.put(8, "price");
      sKeys.put(9, "product");
      sKeys.put(10, "totalPrice");
      sKeys.put(11, "tranFee");
      sKeys.put(12, "user");
      sKeys.put(13, "userViewModel");
      sKeys.put(14, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(20);

    static {
      sKeys.put("layout/activity_edit_profile_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_edit_profile);
      sKeys.put("layout/activity_order_detail_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_order_detail);
      sKeys.put("layout/activity_product_detail_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_product_detail);
      sKeys.put("layout/activity_product_in_category_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.activity_product_in_category);
      sKeys.put("layout/bottom_sheet_add_cart_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.bottom_sheet_add_cart);
      sKeys.put("layout/fragment_address_cart_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_address_cart);
      sKeys.put("layout/fragment_confirm_order_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_confirm_order);
      sKeys.put("layout/fragment_forgot_password_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_forgot_password);
      sKeys.put("layout/fragment_login_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_login);
      sKeys.put("layout/fragment_sign_in_up_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_sign_in_up);
      sKeys.put("layout/fragment_sign_up_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_sign_up);
      sKeys.put("layout/fragment_user_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.fragment_user);
      sKeys.put("layout/item_category_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_category);
      sKeys.put("layout/item_order_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_order);
      sKeys.put("layout/item_order_status_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_order_status);
      sKeys.put("layout/item_product_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product);
      sKeys.put("layout/item_product_cart_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_cart);
      sKeys.put("layout/item_product_confirm_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_confirm);
      sKeys.put("layout/item_product_order_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_order);
      sKeys.put("layout/item_product_sale_0", thuypham.n16dccn159.ptithcm.sellingapp.R.layout.item_product_sale);
    }
  }
}
