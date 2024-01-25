// Layout.tsx
import React, {FC, PropsWithChildren} from "react";
import AuthLayout from "@/components/layout/AuthLayout";
import MainLayout from "@/components/layout/MainLayout";

interface LayoutProps extends PropsWithChildren<any> {
  isAuthPage?: boolean;
}

const Layout: FC<LayoutProps> = ({children, isAuthPage}) => {
  return isAuthPage ? <AuthLayout>{children}</AuthLayout> : <MainLayout>{children}</MainLayout>;
}

export default Layout;