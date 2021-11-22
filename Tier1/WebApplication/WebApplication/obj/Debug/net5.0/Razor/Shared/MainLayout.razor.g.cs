#pragma checksum "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "711c46aa4ed61e30b4af995002955a360fec2b45"
// <auto-generated/>
#pragma warning disable 1591
namespace WebApplication.Shared
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web.Virtualization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 1 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
using WebApplication.Auth;

#line default
#line hidden
#nullable disable
    public partial class MainLayout : LayoutComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenElement(0, "div");
            __builder.AddAttribute(1, "class", "page");
            __builder.OpenElement(2, "div");
            __builder.AddAttribute(3, "class", "page-content");
            __builder.OpenElement(4, "div");
            __builder.AddAttribute(5, "id", "topbar");
            __builder.OpenComponent<WebApplication.Shared.NavMenu>(6);
            __builder.CloseComponent();
            __builder.AddMarkupContent(7, "\r\n            ");
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Authorization.AuthorizeView>(8);
            __builder.AddAttribute(9, "NotAuthorized", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Authorization.AuthenticationState>)((context) => (__builder2) => {
                __builder2.OpenElement(10, "div");
                __builder2.OpenElement(11, "button");
                __builder2.AddAttribute(12, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 14 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
                                            () => NavManager.NavigateTo("/login")

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(13, "class", "topbar-btn");
                __builder2.AddContent(14, " Log In");
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.AddAttribute(15, "Authorized", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Authorization.AuthenticationState>)((context) => (__builder2) => {
                __builder2.OpenElement(16, "div");
                __builder2.OpenElement(17, "a");
                __builder2.AddAttribute(18, "class", "topbar-btn");
                __builder2.AddAttribute(19, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 19 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
                                                        Logout

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(20, "href", "#");
                __builder2.AddContent(21, "Logout");
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.CloseComponent();
            __builder.CloseElement();
            __builder.AddMarkupContent(22, "\r\n\r\n        ");
            __builder.OpenElement(23, "div");
            __builder.AddAttribute(24, "class", "hw-main-page-container");
            __builder.AddContent(25, 
#nullable restore
#line 26 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
             Body

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 32 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
 

    protected override async Task OnInitializedAsync()
    {
    }

    private void Logout()
    {
        ((CustomAuthenticationStateProvider) AuthenticationStateProvider).Logout();
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private AuthenticationStateProvider AuthenticationStateProvider { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavManager { get; set; }
    }
}
#pragma warning restore 1591
