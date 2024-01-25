import React, {FC} from "react";
import FormInput from "src/components/forms/login-form";
import {Avatar, Box, Button, Checkbox, FormControlLabel, Grid, Typography} from "@mui/material";
import {LockOutlined} from "@mui/icons-material";
import {Link, Outlet} from "react-router-dom";
import {getLoginSchema, ILogin} from "@/types/login";
import {FormProvider, SubmitHandler, useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import LoginForm from "src/components/forms/login-form";

const LoginPage: FC = () => {

  return (
      <>
        <Avatar sx={{m: 1, bgcolor: 'secondary.main'}}>
          <LockOutlined/>
        </Avatar>
        <Typography component="h1" variant="h5">
          로그인
        </Typography>
        <LoginForm />
      </>
  );
}

export default LoginPage;