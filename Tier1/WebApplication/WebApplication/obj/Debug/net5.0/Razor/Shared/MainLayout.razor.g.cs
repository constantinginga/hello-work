#pragma checksum "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "9e97bd0f19fadb253800c34deab32938f53f21bc"
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
            __builder.AddAttribute(2, "b-xwlbgainx3");
            __builder.OpenElement(3, "div");
            __builder.AddAttribute(4, "class", "sidebar");
            __builder.AddAttribute(5, "b-xwlbgainx3");
            __builder.OpenComponent<WebApplication.Shared.NavMenu>(6);
            __builder.CloseComponent();
            __builder.CloseElement();
            __builder.AddMarkupContent(7, "\r\n\r\n    ");
            __builder.OpenElement(8, "div");
            __builder.AddAttribute(9, "class", "main bg-white");
            __builder.AddAttribute(10, "b-xwlbgainx3");
            __builder.OpenElement(11, "div");
            __builder.AddAttribute(12, "class", "top-row px-4");
            __builder.AddAttribute(13, "b-xwlbgainx3");
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Authorization.AuthorizeView>(14);
            __builder.AddAttribute(15, "NotAuthorized", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Authorization.AuthenticationState>)((context) => (__builder2) => {
                __builder2.OpenElement(16, "div");
                __builder2.AddAttribute(17, "b-xwlbgainx3");
                __builder2.OpenElement(18, "button");
                __builder2.AddAttribute(19, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 16 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
                                            () => NavManager.NavigateTo("/login")

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(20, "class", "btn btn-outline-dark hover:bg-blue-700 w-full btn-outline-primary login");
                __builder2.AddAttribute(21, "type", "button");
                __builder2.AddAttribute(22, "b-xwlbgainx3");
                __builder2.AddContent(23, " Log In");
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.AddAttribute(24, "Authorized", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Authorization.AuthenticationState>)((context) => (__builder2) => {
                __builder2.OpenElement(25, "div");
                __builder2.AddAttribute(26, "b-xwlbgainx3");
                __builder2.OpenElement(27, "a");
                __builder2.AddAttribute(28, "class", "");
                __builder2.AddAttribute(29, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 21 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
                                              Logout

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(30, "href", "#");
                __builder2.AddAttribute(31, "b-xwlbgainx3");
                __builder2.AddContent(32, "Logout");
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.CloseComponent();
            __builder.CloseElement();
            __builder.AddMarkupContent(33, "\r\n\r\n        ");
            __builder.OpenElement(34, "div");
            __builder.AddAttribute(35, "class", "content px-4 ");
            __builder.AddAttribute(36, "b-xwlbgainx3");
            __builder.AddContent(37, 
#nullable restore
#line 28 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
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
#line 34 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Shared\MainLayout.razor"
 

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
