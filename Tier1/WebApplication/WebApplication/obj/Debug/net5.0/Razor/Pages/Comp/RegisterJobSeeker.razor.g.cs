#pragma checksum "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "42680f0a58601da67b11b213733d6eafe3ae7177"
// <auto-generated/>
#pragma warning disable 1591
namespace WebApplication.Pages.Comp
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web.Virtualization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 1 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
using WebApplication.Auth;

#line default
#line hidden
#nullable disable
    public partial class RegisterJobSeeker : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Forms.EditForm>(0);
            __builder.AddAttribute(1, "Model", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Object>(
#nullable restore
#line 6 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                  _newJobSeeker

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(2, "OnValidSubmit", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<Microsoft.AspNetCore.Components.Forms.EditContext>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Forms.EditContext>(this, 
#nullable restore
#line 6 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                                                 AddNewJobSeeker

#line default
#line hidden
#nullable disable
            )));
            __builder.AddAttribute(3, "ChildContent", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Forms.EditContext>)((context) => (__builder2) => {
                __builder2.OpenElement(4, "div");
                __builder2.AddAttribute(5, "class");
                __builder2.AddAttribute(6, "b-hmjnaprctd");
                __builder2.OpenElement(7, "div");
                __builder2.AddAttribute(8, "class", "flex justify-center element");
                __builder2.AddAttribute(9, "b-hmjnaprctd");
                __builder2.OpenElement(10, "div");
                __builder2.AddAttribute(11, "class", "lg:w-10/12  rounded-lg");
                __builder2.AddAttribute(12, "b-hmjnaprctd");
                __builder2.OpenElement(13, "div");
                __builder2.AddAttribute(14, "class", "d-flex flex-row w-full pb-2");
                __builder2.AddAttribute(15, "b-hmjnaprctd");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.DataAnnotationsValidator>(16);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(17, "\r\n                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.ValidationSummary>(18);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(19, "\r\n                    ");
                __builder2.OpenElement(20, "p");
                __builder2.AddAttribute(21, "b-hmjnaprctd");
                __builder2.AddContent(22, 
#nullable restore
#line 16 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                         _errorMessage

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(23, "\r\n                ");
                __builder2.OpenElement(24, "div");
                __builder2.AddAttribute(25, "class", "d-flex flex-row w-full pb-2");
                __builder2.AddAttribute(26, "b-hmjnaprctd");
                __builder2.OpenElement(27, "div");
                __builder2.AddAttribute(28, "class", "col-6 p-0 pr-1");
                __builder2.AddAttribute(29, "b-hmjnaprctd");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(30);
                __builder2.AddAttribute(31, "DisplayName", "Company name");
                __builder2.AddAttribute(32, "placeholder", "First name");
                __builder2.AddAttribute(33, "class", "bg-white w-full rounded-lg border-0");
                __builder2.AddAttribute(34, "type", "text");
                __builder2.AddAttribute(35, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 21 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                                                                                                                                                           _newJobSeeker.FirstName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(36, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => _newJobSeeker.FirstName = __value, _newJobSeeker.FirstName))));
                __builder2.AddAttribute(37, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => _newJobSeeker.FirstName));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(38, "\r\n                    ");
                __builder2.OpenElement(39, "div");
                __builder2.AddAttribute(40, "class", "col-6 p-0 pl-1");
                __builder2.AddAttribute(41, "b-hmjnaprctd");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(42);
                __builder2.AddAttribute(43, "DisplayName", "Phone Number");
                __builder2.AddAttribute(44, "placeholder", "Last name");
                __builder2.AddAttribute(45, "class", "bg-white w-full  rounded-lg border-0");
                __builder2.AddAttribute(46, "type", "text");
                __builder2.AddAttribute(47, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 24 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                                                                                                                                                            _newJobSeeker.LastName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(48, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => _newJobSeeker.LastName = __value, _newJobSeeker.LastName))));
                __builder2.AddAttribute(49, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => _newJobSeeker.LastName));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(50, "\r\n                ");
                __builder2.OpenElement(51, "div");
                __builder2.AddAttribute(52, "class", "form-group m-0 pb-2");
                __builder2.AddAttribute(53, "b-hmjnaprctd");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(54);
                __builder2.AddAttribute(55, "DisplayName", "Address");
                __builder2.AddAttribute(56, "placeholder", "Phone number");
                __builder2.AddAttribute(57, "class", "bg-white w-full  rounded-lg border-0");
                __builder2.AddAttribute(58, "type", "text");
                __builder2.AddAttribute(59, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 28 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                                                                                                                                                      _newJobSeeker.PhoneNumber

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(60, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => _newJobSeeker.PhoneNumber = __value, _newJobSeeker.PhoneNumber))));
                __builder2.AddAttribute(61, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => _newJobSeeker.PhoneNumber));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(62, "\r\n                ");
                __builder2.OpenElement(63, "div");
                __builder2.AddAttribute(64, "class", "form-group m-0 pb-2");
                __builder2.AddAttribute(65, "b-hmjnaprctd");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(66);
                __builder2.AddAttribute(67, "DisplayName", "Email");
                __builder2.AddAttribute(68, "placeholder", "Email");
                __builder2.AddAttribute(69, "class", "bg-white w-full rounded-lg border-0");
                __builder2.AddAttribute(70, "type", "text");
                __builder2.AddAttribute(71, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 31 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                                                                                                                                           _newJobSeeker.Email

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(72, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => _newJobSeeker.Email = __value, _newJobSeeker.Email))));
                __builder2.AddAttribute(73, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => _newJobSeeker.Email));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(74, "\r\n                ");
                __builder2.OpenElement(75, "div");
                __builder2.AddAttribute(76, "class", "form-group m-0 pb-2");
                __builder2.AddAttribute(77, "b-hmjnaprctd");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(78);
                __builder2.AddAttribute(79, "DisplayName", "Password");
                __builder2.AddAttribute(80, "placeholder", "Password");
                __builder2.AddAttribute(81, "class", "bg-white w-full rounded-lg border-0");
                __builder2.AddAttribute(82, "type", "Password");
                __builder2.AddAttribute(83, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 34 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
                                                                                                                                                     _newJobSeeker.Password

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(84, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => _newJobSeeker.Password = __value, _newJobSeeker.Password))));
                __builder2.AddAttribute(85, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => _newJobSeeker.Password));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(86, "\r\n                ");
                __builder2.AddMarkupContent(87, "<div class=\"pb-2 flex justify-center w-full\" b-hmjnaprctd><button class=\"btn hover:bg-blue-600 btn-outline-dark w-full\" data-dismiss=\"model\" type=\"submit\" b-hmjnaprctd>Add</button></div>");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.CloseComponent();
        }
        #pragma warning restore 1998
#nullable restore
#line 45 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\Comp\RegisterJobSeeker.razor"
       
    private JobSeeker _newJobSeeker = new JobSeeker();
    private string _errorMessage;

    private async void AddNewJobSeeker()
    {
        try
        {
            await ((CustomAuthenticationStateProvider) AuthenticationStateProvider).CreateJobSeeker(_newJobSeeker);
        }
        catch (Exception e)
        {
            _errorMessage = e.Message;
            StateHasChanged();
            return;
        }
        Console.WriteLine("added");
        await ((CustomAuthenticationStateProvider) AuthenticationStateProvider).ValidateLogin(_newJobSeeker.Email, _newJobSeeker.Password);

        navigationManager.NavigateTo("/");
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager navigationManager { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private AuthenticationStateProvider AuthenticationStateProvider { get; set; }
    }
}
#pragma warning restore 1591
