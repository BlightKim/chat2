import React, {FC} from "react";
import PageTitle from "@/components/common/page-title";
import AppInfo from "@/components/app-info/AppInfo";

const HomePage: FC = () => {
    return (
        <>
            <PageTitle>HomePage</PageTitle>
            <AppInfo />
        </>
    );
}
export default HomePage;