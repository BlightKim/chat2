import React from 'react';
import './App.css';
import Layout from "@/components/layout/Layout";
import {AppBar} from "@mui/material";
import AppRouter from "@/components/routing/app-router";
import {useLocation} from "react-router-dom";
import {Paths} from "@/routes";


const App = () => {
  const location = useLocation();

  const isAuthPage = [Paths.LOGIN, Paths.SIGNUP].includes(location.pathname as Paths);
  return (
      <Layout isAuthPage={isAuthPage}>
          <AppRouter />
      </Layout>
  );
}

export default App;
