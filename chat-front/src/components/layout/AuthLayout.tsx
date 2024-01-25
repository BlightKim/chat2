import React, {FC, PropsWithChildren} from "react";
import {Box, Container, CssBaseline} from "@mui/material";
import {Copyright} from "@mui/icons-material";

const AuthLayout: FC<PropsWithChildren> = ({children}) => {
  return (
      <Container component="main" maxWidth="xl">
        <CssBaseline />
        <Box
            sx={{
              marginTop: 8,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
        >
          {children}
        </Box>
        <Copyright sx={{ mt: 5 }} />
      </Container>
  );
}

export default AuthLayout;