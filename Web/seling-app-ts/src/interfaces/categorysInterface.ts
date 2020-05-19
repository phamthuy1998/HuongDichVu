import { CATEGORY, PROS_OF_CATE } from '../actions/types';
export interface CategorysState {
    categorys: any[],
    prosOfCate: any[]
}

interface GetCategoryAction {
    type: typeof CATEGORY,
    categorys: any[]
}

interface GetProsByCateAction {
    type: typeof PROS_OF_CATE,
    prosOfCate: any[]
}
export type CategorysActionTypes =
    GetCategoryAction
    | GetProsByCateAction;