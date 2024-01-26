import React, {FC} from "react";
import {Box, Button, Checkbox, FormControlLabel, Grid, Typography} from "@mui/material";
import {Link} from "react-router-dom";
import FormInput from "@/components/common/form-input";
import {FormProvider, SubmitHandler, useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import {getSignupSchema, ISignup} from "@/types/signup";
import {getData, postData} from "@/api";


const SignupForm: FC = () => {
  const defaultValues: ISignup = {
    name: '',
    email: '',
    password: '',
    passwordConfirm: '',
    agreePolicy: false
  };

  // 👇 The object returned from useForm Hook
  const formMethods = useForm<ISignup>({
    resolver: zodResolver(getSignupSchema()),
    defaultValues,
  });

  const onSubmitHandler: SubmitHandler<ISignup> = async (values: ISignup) => {
    const response = await postData<any>('/user');

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
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <FormInput
                fullWidth
                margin='normal'
                label='이름'
                type='text'
                name='name'
                focused
                required
            />
          </Grid>
          <Grid item xs={12}>
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
          <Grid item xs={12}>
            <FormInput
                fullWidth
                type='password'
                label='비밀번호'
                name='password'
                required
                focused
            />
          </Grid>
          <Grid item xs={12}>
            <FormInput
                fullWidth
                type='password'
                label='비밀번호 확인'
                name='passwordConfirm'
                required
                focused
            />
          </Grid>
          <Grid item xs={12}>
            <FormControlLabel
                control={
                  <Checkbox
                      size='small'
                      aria-label='trust this device checkbox'
                      required
                      {...formMethods.register('agreePolicy')}
                  />
                }
                label={
                  <Typography
                      variant='body'
                      sx={{
                        fontSize: '0.8rem',
                        fontWeight: 400,
                        color: '#5e5b5d',
                      }}
                  >
                    정책에 동의하십니까 ?
                  </Typography>
                }
            />
            {formMethods.formState.errors.agreePolicy && (
                <Typography variant="body2" color="error">
                  {formMethods.formState.errors.agreePolicy.message}
                </Typography>
            )}

          </Grid>
        </Grid>
        <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{mt: 3, mb: 2}}
        >
          Sign Up
        </Button>
        <Grid container justifyContent="flex-end">
          <Grid item>
            <Link to="/login" variant="body2">
              이미 계정이 있으신가요 ? 로그인
            </Link>
          </Grid>
        </Grid>
      </Box></FormProvider>
  );
};

export default SignupForm;
