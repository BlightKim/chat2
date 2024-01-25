// MainLayout.tsx
import React, {FC, PropsWithChildren} from "react";
import {
  Badge,
  Box,
  Container,
  CssBaseline,
  Grid,
  IconButton,
  Toolbar,
  Typography
} from "@mui/material";
import Header from "@/components/header/Header";
import Drawer from "@/components/drawer/Drawer";
import {Simulate} from "react-dom/test-utils";
import toggle = Simulate.toggle;
import {ChevronLeft, Menu, MenuBook, MenuOpen, Notifications} from "@mui/icons-material";
import {useAppSelector} from "@/hooks/redux";
import {getDrawerState} from "@/store/selectors/authSelectors";
import {useDispatch} from "react-redux";
import {drawerSlice} from "@/store/slices/drawerSlice";
import AppBar from "@/components/app-bar/AppBar";

const MainLayout: FC<PropsWithChildren> = ({children}) => {
  const dispatch = useDispatch();

  const {isOpen} = useAppSelector(getDrawerState);

  const toggle = () => {
    dispatch(drawerSlice.actions.toggle());
  }
  return (
      <>
        <Box sx={{display: 'flex'}}>
          <CssBaseline/>
          <AppBar position="absolute" open={isOpen}>
            <Toolbar
                sx={{
                  pr: '24px'
                }}>
              <IconButton
                  edge="start"
                  color="inherit"
                  aria-label="open drawer"
                  onClick={toggle}
                  sx={{
                    marginRight: '36px',
                    ...(isOpen && {display: 'none'}),
                  }}>
                <Menu/>
              </IconButton>
              <Typography
                  component="h1"
                  variant="h6"
                  color="inherit"
                  noWrap
                  sx={{flexGrow: 1}}
              >
                Dashboard
              </Typography>
              <IconButton
                  color="inherit">
                <Badge badgeContent={4} color="secondary">
                  <Notifications/>
                </Badge>
              </IconButton>
            </Toolbar>
          </AppBar>
          <Drawer variant="permanent" open={isOpen}>
            <Toolbar
                sx={{
                  display: 'flex',
                  alignItems: 'center',
                  justifyContent: 'flex-end',
                  px: [1]
                }}
            >
              <IconButton onClick={toggle}>
                <ChevronLeft/>
              </IconButton>
            </Toolbar>
          </Drawer>
          <Box
              component="main"
              sx={{
                backgroundColor: (theme) =>
                    theme.palette.mode === 'light'
                        ? theme.palette.grey[100]
                        : theme.palette.grey[900],
                flexGrow: 1,
                height: '100vh',
                overflow: 'auto',
              }}
          >
            <Container maxWidth="lg" sx={{mt: 4, mb: 4}}>
              <Grid container spacing={3}>
                <Grid item xs={12} md={12} lg={12}>
                  {children}
                </Grid>
              </Grid>

            </Container>
            <Toolbar/>
          </Box>
        </Box>
      </>
  );
}

export default MainLayout;