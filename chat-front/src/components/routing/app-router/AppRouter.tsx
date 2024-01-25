import React, {FC, PropsWithChildren} from "react";
import {Route, Routes} from "react-router-dom";
import AuthWrapper from "@/components/routing/auth-wrapper/AuthWrapper";
import {authRoutes, publicRoutes} from "@/routes";
import * as path from "path";
import Layout from "@/components/layout/Layout";

const AppRouter: FC = () => {
  return (


      <Routes>
          <Route element={<AuthWrapper/>}>


          </Route>
          {publicRoutes.map(({path, Component}) => (
              <Route key={path} path={path} element={<Component/>}/>
          ))}
      </Routes>

  );
}

export default AppRouter;