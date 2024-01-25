import React, {ComponentType} from "react";
import {FC} from "react";
import PageTitle from "@/components/common/page-title";
import SignupForm from "src/components/forms/signup-form";
import {
  Avatar,
  Box,
  Button,
  Checkbox,
  FormControlLabel,
  Grid,
  TextField,
  Typography
} from "@mui/material";
import {LockOutlined} from "@mui/icons-material";
import {Link} from "react-router-dom";
import {object} from "zod";
const SignupPage: FC = () => {

  return (
      <>
        <Avatar sx={{m: 1, bgcolor: 'secondary.main'}}>
          <LockOutlined/>
        </Avatar>
        <Typography component="h1" variant="h5">
          회원가입
        </Typography>
        <SignupForm />
      </>
  );
}
export default SignupPage;