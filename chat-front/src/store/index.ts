import {combineReducers, configureStore} from "@reduxjs/toolkit";
import {authSlice} from "@/store/slices/authSlice";
import {baseApi} from "@/store/api/baseApi";
import {drawerSlice} from "@/store/slices/drawerSlice";

const rootReducer = combineReducers({
    auth: authSlice.reducer,
    drawer: drawerSlice.reducer,
    [baseApi.reducerPath]: baseApi.reducer
});

export const setupStore = () => configureStore({
    reducer: rootReducer,
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(baseApi.middleware)
})


export const store = setupStore();
export type RootState = ReturnType<typeof rootReducer>;
export type AppStore = ReturnType<typeof setupStore>;
export type AppDispatch = AppStore["dispatch"];
