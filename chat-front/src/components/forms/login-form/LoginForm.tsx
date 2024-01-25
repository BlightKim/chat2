import React, {FC} from "react";
import {Box, Button, Checkbox, FormControlLabel, Grid} from "@mui/material";
import FormInput from "@/components/common/form-input";
import {FormProvider, SubmitHandler, useForm} from "react-hook-form";
import {getLoginSchema, ILogin} from "@/types/login";
import {zodResolver} from "@hookform/resolvers/zod";
import {Link, Outlet} from "react-router-dom";

const LoginForm:FC = () => {
  const defaultValues: ILogin = {
    email: '',
    password: '',
  };

  // 👇 The object returned from useForm Hook
  const formMethods = useForm<ILogin>({
    resolver: zodResolver(getLoginSchema()),
    defaultValues,
  });

  // 👇 Submit Handler
  const onSubmitHandler: SubmitHandler<ILogin> = (values: ILogin) => {
    console.log(values);
  }
  return (
      <FormProvider {...formMethods}>
        <Box component="form" noValidate sx={{
          mt: 1,
          width: {
            xs: '100%',  // 작은 화면에서의 너비
            sm: '75%',  // 중간 크기의 화면에서의 너비
            md: '50%',  // 큰 화면에서의 너비
            lg: '500px'
          },
        }}
             onSubmit={formMethods.handleSubmit(onSubmitHandler)}
        >
          <Grid item
          >
            <FormInput
                fullWidth
                margin='normal'
                label='이메일'
                type='email'
                name='email'
                focused
                required
            />
          </Grid>
          <Grid item
                xs={12}
          >
            <FormInput
                fullWidth
                type='password'
                label='비밀번호'
                name='password'
                required
                focused
            />
          </Grid>

          <FormControlLabel
              control={<Checkbox value="remember" color="primary"/>}
              label="아이디 기억하기"
          />
          <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{mt: 3, mb: 2}}
          >
            로그인
          </Button>
          <Grid container>
            <Grid item xs>
              <Outlet/>
            </Grid>
            <Grid item>
              <Link to="/login">
                {"계정이 없으신가요? 가입하기"}
              </Link>
            </Grid>
          </Grid>
        </Box>
      </FormProvider>
  );
}

export default LoginForm